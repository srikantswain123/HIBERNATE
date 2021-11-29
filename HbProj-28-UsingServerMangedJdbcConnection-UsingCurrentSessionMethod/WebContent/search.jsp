<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<h1 style="color:green;text-align:center">Prodct Result</h1>
<c:choose>
   <c:when test="${!empty Prod || Prod ne null }">
   <table bgcolor="cyan" align="center" border="1" >
  <tr>
  <td>${Prod.getPid()}</td>
  <td>${Prod.getPidname()}</td>
  <td>${Prod.getPrice()}</td>
  <td>${Prod.getQty()}</td>
  <td>${Prod.getStartegy()}</td>
  </tr>
      </table>
    </c:when>
    <c:otherwise>
    <h1 style="color:red;text-align:center">No prodcut Details Found</h1>
    </c:otherwise>
</c:choose>




<%--
if(request.getAttribute("Prod")!=null){%>
<table bgcolor="cyan" align="center" border="1" >
  <tr>
  <td>${Prod.getPid()}</td>
  <td>${Prod.getPidname()}</td>
  <td>${Prod.getPrice()}</td>
  <td>${Prod.getQty()}</td>
  <td>${Prod.getStartegy()}</td>
  </tr>
</table>
<%
}else{%>
<h1 style="color:red;text-align:center">No prodcut Details Found</h1>
<%	
}
%> --%>
<a href="input.html">Home</a>