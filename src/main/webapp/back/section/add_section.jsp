<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="request" var="base_path" value="${pageContext.request.contextPath}"/>

<div style="text-align:center;margin-top:30px;">
    <form id="addSpecialForm" method="post" enctype="multipart/form-data">
        <div style="margin-top:10px;">
            <input type="text" name="special_id" value="${param.id}"/><br/>
        </div>
        <div style="margin-top:10px;">
            章节名称:<input id="name" name="name" type="text" class="easyui-textbox"/><br/>
        </div>
        <div style="margin-top:10px;">
            上传章节:<input id="file" name="file" class="easyui-filebox" data-options="buttonText:'选择'"/><br/>
        </div>
    </form>
</div>