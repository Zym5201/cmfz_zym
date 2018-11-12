<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="request" var="base_path" value="${pageContext.request.contextPath}"/>
<script>
    $(function(){
        $("#specialContext").form('load','${pageContext.request.contextPath}/special/queryOne?id=${param.id}');
    })
</script>

<div style="text-align:center;margin-top:30px;">
    <form id="specialContext" method="post">
        专辑名称:<input id="pic" name="pic" type="text" class="easyui-textbox"/><br/>
        专辑名称:<input id="name" name="name" type="text" class="easyui-textbox"/><br/>
        作　　者:<input id="author" name="author" type="text" class="easyui-textbox"/><br/>
        播　　音:<input id="broadcast" name="broadcast" type="text" class="easyui-textbox"/><br/>
        集　　数:<input id="collect_number" name="collect_number" type="text" class="easyui-textbox"/><br/>
        发布日期:<input id="issue_date" name="issue_date" type="text" class="easyui-textbox"/><br/>
        状　　态:<input id="state" name="state" type="text" class="easyui-textbox"/><br/>
        <textarea style="width:190px;height:80px;border:1px solid #fff3f3;" name="content_synopsis"></textarea><br/>
    </form>
</div>