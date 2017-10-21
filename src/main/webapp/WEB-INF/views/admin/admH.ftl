
<#import "/spring.ftl" as spring/>

<html>
<head>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<#--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"-->
   <#--"http://www.w3.org/TR/html4/loose.dtd">-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin HomePage</title>
</head>
<body>
    <div align="center">
        <h1>Services</h1>

        <table border="1">

//description,userid,dayofrepair,repairstatus,repairtype,servicecost,platenumber

            <th>Description</th>
            <th>Dayofrepair</th>
            <th>Repairstatus</th>
            <th>Repairtype</th>
            <th>Servicecost</th>
            <th>Platenumber</th>
            <th>TaxNumber</th>


            <c:forEach var="repairRow" items="${serviceList}">
                <tr>


                    <td>${repairRow.Description}</td>
                    <td>${repairRow.Dayofrepair}</td>
                    <td>${repairRow.Repairstatus}</td>
                    <td>${repairRow.Repairtype}</td>
                    <td>${repairRow.Servicecost}</td>
                    <td>${repairRow.Platenumber}</td>
                    <td>${repairRow.TaxNumber}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
</body>

</html>