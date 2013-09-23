<%@page contentType="text/html; utf-8" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JSP Template Inheritance in /WEB-INF</title>
        <style type="text/css">
            div.header {border: 2px solid deepskyblue; background-color: gray;}
            div.body {border: 2px solid burlywood; background-color: silver;}
            div.footer {border: 2px solid crimson; background-color: activeborder;}
        </style>
    </head>
    <h1>Base Layout</h1>
    <div class="header">
        <layout:module name="header">
            <p>(PREPEND)<c:out value="${testProperty}" escapeXml="true"/></p>
            <hr />
        </layout:module>
    </div>
    <div class="body">
        <layout:module name="body">
            <div><strong>(APPEND) start body .......</strong></div>
        </layout:module>
    </div>
    <div class="footer">
        <div>(REPLACE)</div>
        <layout:module name="footer">
            <div>This line must be replaced by children's footer.</div>
        </layout:module>
    </div>
</html>

