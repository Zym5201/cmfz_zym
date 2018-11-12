<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%--添加--%>
<div style="text-align: center;">
    <form id="addff" method="post" enctype="multipart/form-data">
        <div style="text-align:center;margin-top:15px;">上传图片: <input name="file" type="text" class="easyui-filebox" data-options="buttonText:'选择文件',width:150,"/></div>

        <div style="text-align:center;margin-top:15px;">标 &nbsp;题: &nbsp;&nbsp; &nbsp;&nbsp;<input name="title" type="text" class="easyui-textbox" data-options="width:150,"/></div>
        <div style="text-align:center;margin-top:15px;">状&nbsp;态:  &nbsp;&nbsp;&nbsp;&nbsp;<input name="status" type="text" class="easyui-textbox" data-options="width:150"/></div>
        <div style="text-align:center;margin-top:15px;">图片描述: <input name="descd" type="text" class="easyui-textbox" data-options="width:150,"/></div>
    </form>
</div>