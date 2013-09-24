<%@page contentType="text/html; utf-8" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>This contents will be ignored because of forward.</div>
<layout:extends name="/WEB-INF/layouts/secondLayout.jsp">
    <c:set var="testProperty" value="test property must be shown from the grand son" scope="request"/>

    <layout:put name="header">
        <h3>JSP Template Inheritance</h3>
    </layout:put>

    <div>This is useless html.</div>

    <layout:put name="body">
        First body in index.jsp
    </layout:put>
    <layout:put name="body">
        Second body in index.jsp
    </layout:put>
    <layout:put name="footer" type="REPLACE">
    	FOOTER
    </layout:put>
	<jsp:include page="/module.jsp"></jsp:include>
</layout:extends>

