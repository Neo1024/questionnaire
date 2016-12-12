package edu.cuit.questionnaire.web.velocity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

/**
 * Spring4默认的 createVelocityContext 方法中采用的是 tools-1.x 的 ToolboxManager,
 * ServletToolboxManager等类 加载toolbox，但是 tools 2.x 中已经废弃了这些类，导致了无法加载tools 2.x。
 * 所以，这里采用tools 2.x中新的 ToolManager方式重写此方法加载toolbox2.x。
 */
public class VelocityLayoutToolboxView extends VelocityLayoutView {

    @Override
    protected Context createVelocityContext(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ViewToolContext ctx = new ViewToolContext(getVelocityEngine(), request,
                response, getServletContext());

        ctx.putAll(model);
        if (this.getToolboxConfigLocation() != null) {
            ToolManager tm = new ToolManager();
            tm.setVelocityEngine(getVelocityEngine());
            tm.configure(getServletContext().getRealPath(
                    getToolboxConfigLocation()));
            if (tm.getToolboxFactory().hasTools(Scope.REQUEST)) {
                ctx.addToolbox(tm.getToolboxFactory().createToolbox(
                        Scope.REQUEST));
            }
            if (tm.getToolboxFactory().hasTools(Scope.APPLICATION)) {
                ctx.addToolbox(tm.getToolboxFactory().createToolbox(
                        Scope.APPLICATION));
            }
            if (tm.getToolboxFactory().hasTools(Scope.SESSION)) {
                ctx.addToolbox(tm.getToolboxFactory().createToolbox(
                        Scope.SESSION));
            }
        }
        return ctx;
    }
}
