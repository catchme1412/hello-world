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
           base layout header
        </layout:module>
    </div>
    <div class="body">
        <layout:module name="body">
            base layout body
        </layout:module>
    </div>
    <div class="footer">
        <layout:module name="footer">
            base layout footer
        </layout:module>
    </div>
</html>

