<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,pojos.LogisticsPlan"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>外包物流选择系统</h3>
	<h6>欢迎你<s:property value="users.username"/></h6>
   <form name="myform1" action="tast/generateplan.action" method="post">  
             订单编号:<input  name="logisticsplan.ordernumber"   value=<%=new String(request.getParameter("ordernumber").getBytes("iso-8859-1"),"utf-8")%>><br>         
              发货点省份:<input  name="logisticsplan.departureplace"   value=<%=new String(request.getParameter("departureplace").getBytes("iso-8859-1"),"utf-8")%> ><br>  
              收货点省份:<input  name="logisticsplan.destination"   value=<%=new String(request.getParameter("destination").getBytes("iso-8859-1"),"utf-8")%>><br>  
              货物重量:<input  name="logisticsplan.weight"  value=<%=Integer.parseInt(new String(request.getParameter("weight").getBytes("iso-8859-1"),"utf-8"))%>><br>  
    <input type="submit" value="计算物流方案" > 
   </form>  
   <form name="myform2" action="tast/uploadplan.action" method="post">  
    <br>
    <p>物流方案：</p>
    <h6><s:property value="logisticsplan.planning"/><s:property value="uu"/></h6>
    <input type="submit" value="上传物流方案" >  
   </form>  
    
</body>
</html>

