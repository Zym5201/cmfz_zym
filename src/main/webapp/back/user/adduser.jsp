<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="request" var="base_path" value="${pageContext.request.contextPath}"/>


<div style="text-align:center;margin-top:30px;">
    <form id="addUserForm" method="post" enctype="multipart/form-data">
        <div style="margin-top:10px;">
            用户名:<input type="text" name="username" class="easyui-textbox" data-options="validType:'phone'"/><br/>
        </div>
        <div style="margin-top:10px;">
            密　码:<input id="password" name="password" type="text" class="easyui-passwordbox"/><br/>
        </div>
        <div style="margin-top:10px;">
            头　像:<input id="file" name="file" type="text" class="easyui-filebox" data-options="buttonText:'选择'"/><br/>
        </div>
        <div style="margin-top:10px;">
            法　号:<input id="dharma_name" name="dharma_name" type="text" class="easyui-textbox"/><br/>
        </div>
        <div style="margin-top:10px;">
            姓　名:<input id="realname" name="realname" type="text" class="easyui-textbox" /><br/>
        </div>
        <div style="margin-top:10px;">
            性　别:<select name="sex" id="sex" style="width:145px;">
                        <option value="男">男</option>
                        <option value="女">女</option>
                   </select>
        </div>

    </form>
</div>