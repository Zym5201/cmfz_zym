<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="request" var="base_path" value="${pageContext.request.contextPath}"/>
<div style="text-align:center;margin-top:30px;">
<form id="addCourseForm" method="post">
    <div style="margin-top:10px;">
        类别名称:<input type="text" class="easyui-textbox" id="name" name="name"/><br/>
    </div>
    <div style="margin-left:-125px;margin-top:20px;">
        是否必修<input name="status" type="checkbox" value="1"/><br/>
    </div>
</form>
</div>