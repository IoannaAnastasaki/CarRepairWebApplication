
<#import "/spring.ftl" as spring/>

<html>
<head>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin HomePage</title>
</head>
<body>
    <div align="center">
        <h1>Services</h1>

        <table border="1">


            <th>Description</th>
            <th>Dayofrepair</th>
            <th>Repairstatus</th>
            <th>Repairtype</th>
            <th>Servicecost</th>
            <th>Platenumber</th>
            <th>TaxNumber</th>




        <#list repairTop10 as repair>
            <tr>
                <td>${repair.dayOfRepair}</td>
                <td>${repair.description}</td>
                <td>${repair.repairStatus}</td>
                <td>${repair.repairType}</td>
                <td>${repair.serviceCost}</td>
            </tr>
        </#list>

            <#--<c:forEach var="repairRow" items="${serviceList}">-->
                <#--<tr>-->


                    <#--<td>${repairRow.Description}</td>-->
                    <#--<td>${repairRow.Dayofrepair}</td>-->
                    <#--<td>${repairRow.Repairstatus}</td>-->
                    <#--<td>${repairRow.Repairtype}</td>-->
                    <#--<td>${repairRow.Servicecost}</td>-->
                    <#--<td>${repairRow.Platenumber}</td>-->
                    <#--<td>${repairRow.TaxNumber}</td>-->

                <#--</tr>-->
            <#--</c:forEach>-->


        </table>
    </div>
</body>

</html>