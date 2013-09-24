<%@page contentType="text/html; utf-8" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:extends name="base.jsp">
    <layout:put name="header" type="APPEND">
        <div>
            <h2>Second Layout Header</h2>
        </div>
    </layout:put>

    <layout:put name="body" type="APPEND">
        <div>
            <h2>Second Layout Body</h2>
        </div>
    </layout:put>

    <layout:put name="footer" type="REPLACE">
        <div>
            <h2>Second Layout footer</h2>
        </div>
    </layout:put>
</layout:extends>