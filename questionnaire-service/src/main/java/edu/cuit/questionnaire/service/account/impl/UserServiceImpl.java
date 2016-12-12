package edu.cuit.questionnaire.service.account.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cuit.questionnaire.model.account.User;
import edu.cuit.questionnaire.persist.account.UserMapper;
import edu.cuit.questionnaire.service.account.UserService;
import edu.cuit.questionnaire.util.Digests;
import edu.cuit.questionnaire.util.Encoders;

/**
 * 
 * @author lixin
 * @date Apr 16, 2016
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public void register(User user) {
		entryptPassword(user);
		userMapper.save(user);
	}

	@Override
	public boolean checkPasswd(String email, String passwd) {
		User origin = userMapper.findByEmail(email);
		String hashPasswd = Encoders.encodeHex(Digests.sha256(
		        passwd.getBytes(), Encoders.decodeHex(origin.getSalt()),
		        Encoders.HASH_INTERATIONS));
		if (origin != null && origin.getPasswd().equals(hashPasswd)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-256 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(Encoders.SALT_SIZE);
		user.setSalt(Encoders.encodeHex(salt));

		byte[] hashPassword = Digests.sha256(user.getPasswd().getBytes(),
		        salt, Encoders.HASH_INTERATIONS);
		user.setPasswd(Encoders.encodeHex(hashPassword));
	}

	@Override
	public User findByEmail(String email) {
		return userMapper.findByEmail(email);
	}
}
