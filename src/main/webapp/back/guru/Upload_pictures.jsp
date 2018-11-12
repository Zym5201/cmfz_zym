<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<div style="text-align:center;margin-top:30px;">
    <form id="picForm" method="post" enctype="multipart/form-data">
        <input id="id" name="id" type="hidden" value="${param.id}"/><br/>
        <input id="file" type="text" class="easyui-filebox" name="file" style="width:120px;" data-options="buttonText:'选择'"/>
    </form>
</div>