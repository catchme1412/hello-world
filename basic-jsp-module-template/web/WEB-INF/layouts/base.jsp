<%@page contentType="text/html; utf-8"%>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<title>${pageTitle}</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" type="image/png" href="/favicon.ico">
<%-- Set the viewport width to device width for mobile --%>
<meta name="viewport" content="width=device-width" />
<layout:module name="head">
</layout:module>
</head>
<layout:module name="bodyTag">
<body>
</layout:module>
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
</body>
</html>
