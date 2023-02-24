//package com.jwt.Jsonwebtoken.conf;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.jwt.Jsonwebtoken.util.JwtUtils;
//
//public class JwtInterceptor extends HandlerInterceptorAdapter {
//	
//	    @Autowired
//	    private JwtUtils jwtUtils;
//
//	    private RequestMeta requestMeta;
//
//	    public JwtInterceptor(RequestMeta requestMeta){
//	        this.requestMeta = requestMeta;
//	    }
//
//	    @Override
//	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//	        String auth = request.getHeader("authorization");
//
//	        if( !(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))){
//	            Claims claims = jwtUtils.verify(auth);
//
//	            requestMeta.setUserName(claims.get("name").toString());
//	            requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
//	            requestMeta.setUserType(claims.get("type").toString());
//	            requestMeta.setEmailId(claims.get("emailId").toString());
//
//	        }
//
//	        return super.preHandle(request, response, handler);
//	    }
//
//}
