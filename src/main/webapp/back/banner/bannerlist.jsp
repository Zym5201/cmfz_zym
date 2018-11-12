<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    $(function(){
        //通过js创建datagrid
        $("#bannerDg").datagrid({
            //用来请求远程数据
            url:'${pageContext.request.contextPath}/banner/querybannerByPage',
            onLoadSuccess:btn,
            fitColumns:true,
            height:500,
            pagination:true,//显示分页工具栏
            pageList:[2,5,10,15,20,50,100],
            pageSize:2,
            tools:'#tools',
            columns:[[
                {field:'ss',checkbox:true},
                {field:'id',title:'id',width:100},
                {field:'title',title:'标题',width:100,align:'center'},
                {field:'imgPath',title:'图片路径',width:100,align:'center'},
                {field:'descd',title:'图片描述',width:100,align:'center'},
                {field:'status',title:'状态',width:100,align:'center'},
                {field:'date',title:'日期',width:150,align:'center'},
                {field:'options',title:'options',width:200,formatter(value,row,index){
                        return  "<a class='del' onclick=deleteOne('"+row.id+"')>删除</a>&nbsp;&nbsp;<a class='upd' onclick=\"updateBanner('"+row.id+"')\">修改</a>";
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){

                return "<table><tr><td><img src='${pageContext.request.contextPath}/back/banner/Uploadpictures/"
                    +rowData.imgPath+"' width='100' width='100'/>" +
                    "</td><td><p>标题:"+rowData.title+"</p>" +
                    "<p>图片路径:"+rowData.imgPath+"</p>" +
                    "<p>图片描述:"+rowData.descd+"</p>" +
                    "</td>" +
                    "</tr>" +
                    "</table>";
            }
        });

        /*操作按钮*/
        function btn() {
            $(".del").linkbutton({
                plain:true,
                iconCls:'icon-remove',
            });
            $(".upd").linkbutton({
                plain:true,
                iconCls:'icon-pencil',
            });
        }
    })

    /*添加*/
    function openSaveUserDialog(){
        $("#add").dialog({
            width:400,
            height:300,
            title:'添加轮播图',
            iconCls:'icon-save',
            href:'${pageContext.request.contextPath}/back/banner/save.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#addff").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/save',
                        success:function(result){
                            var resultObj = $.parseJSON(result);
                            if(resultObj.success) {
                                $.messager.show({title:'提示',iconCls:'icon-bell',msg:"轮播图添加成功!!!"});
                            }else{
                                $.messager.show({title:'提示',iconCls:'icon-bell_error',msg:resultObj.message});
                            }

                            $("#add").dialog('close');
                            $("#bannerDg").datagrid('reload');
                        }
                    });
                }
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $("#c5dcdd").dialog('close');
                }
            }],
        });
    }

    /*删除*/
    function deleteOne(id){
        $.post('${pageContext.request.contextPath}/banner/deleteOne',{id:id},function(result){
            if(result.success){
                $.messager.show({title:'提示',iconCls:'icon-bell',msg:"用户删除成功!!!"});
            }else{
                $.messager.show({title:'提示',iconCls:'icon-bell',msg:result.message});
            }
            $("#bannerDg").datagrid('reload');
        });
    }

    /*修改*/
    function updateBanner(id){
        $("#edit").dialog({
            width: 400,
            height: 300,
            title: '添加轮播图',
            iconCls: 'icon-save',
            href:'${pageContext.request.contextPath}/back/banner/edit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){ /*单击图标时触发的函数*/
                    $("#editff").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/update',
                        method:'POST',
                        success:function(result){
                            var resultObj = $.parseJSON(result);
                            if(resultObj.success){
                                $.messager.show({
                                    title:'我的消息',
                                    iconCls:'icon-bell',
                                    msg:'轮播图修改成功',
                                });
                            }else{
                                $.messager.show({
                                    title:'我的消息',
                                    iconCls:'icon-bell',
                                    msg:resultObj.message,
                                });
                            }
                            $("#edit").dialog('close'),
                                $("#bannerDg").datagrid('reload');
                        }
                    })
                }
            },{
                text:'关闭',
                iconCls:'icon-decline',
                handler:function(){
                    $("#edit").dialog('close');
                }
            }],

        });
    }

    /*//批量删除*/
    function delBatchRows(){
        var rows = $("#bannerDg").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.alert('提示','至少选择一行！！！','info');
        }else{
            var ids=[];
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].id);
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/banner/deleteRows',
                data:{ids:ids},
                type:'POST',
                traditional:true,
                success:function(){
                    $.messager.show({
                        title: '消息',
                        iconCls: 'icon-bell',
                        msg: '删除成功!!',
                    });
                    $("#bannerDg").datagrid('reload');
                },
                error:function() {
                    $.messager.show({
                        title: '消息',
                        iconCls: 'icon-bell_error',
                        msg:"删除失败！！！",
                    });
                    $("#bannerDg").datagrid('reload');
                }
            });

        }
    }


</script>

<%--顶部工具栏--%>
<div id="top_tool">
    <a href="javaScript:void(0)" id="addBanner" class="easyui-linkbutton" onclick="openSaveUserDialog()" data-options="iconCls:'icon-add',plain:true,">添加</a>
    <a href="javaScript:;" class="easyui-linkbutton" onclick="delBatchRows();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
</div>

<table id="bannerDg"></table>
<div id="add"></div>
<div id="edit"></div>