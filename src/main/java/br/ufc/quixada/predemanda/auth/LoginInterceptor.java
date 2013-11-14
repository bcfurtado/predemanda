package br.ufc.quixada.predemanda.auth;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.ufc.quixada.predemanda.controller.IndexController;
import br.ufc.quixada.predemanda.controller.SessaoWeb;

@Intercepts
public class LoginInterceptor implements Interceptor {

	private Result result;
	private SessaoWeb sessaoWeb;

	public LoginInterceptor(Result result, SessaoWeb sessaoWeb) {
		this.result = result;
		this.sessaoWeb = sessaoWeb;
	}

	public boolean accepts(ResourceMethod method) {
		return (method.getMethod().isAnnotationPresent(Restrito.class) || method
				.getResource().getType().isAnnotationPresent(Restrito.class));
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
		if (sessaoWeb.isLogado()) {
			stack.next(method, resourceInstance);
		} else {
			result.forwardTo(IndexController.class).index();
		}
	}

}
