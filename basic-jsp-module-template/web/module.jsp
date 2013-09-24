<%@page contentType="text/html; utf-8"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:put name="header">
	<h3>From module.jsp</h3>
</layout:put>
<jsp:include page="subModule.jsp"></jsp:include>