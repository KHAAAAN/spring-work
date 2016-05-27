<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <style>
    .table-routes{
      width: 100%;
    	text-align: center;
    	background-color: #E6E8EC;
    	font-size: 20px;
    	font-weight: bold;
    }
  </style>

  <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>

<body>

  <table class="table-routes table-hover" border="1">
  <tr>
    <th>Travel Product Id</th>
    <th>Segmentation Rule Name</th>
    <th>Bi Directional</th>
    <th>Exclude</th>
    <th>Origin Airport Set</th>
    <th>Destination Aiport Set</th>
  </tr>
  <c:forEach items="${routes}" varStatus="i">

      <tr>
        <td>${routes[i.index].travelProductID}</td>
        <td>${routes[i.index].segmentationRuleName}</td>
        <td>${routes[i.index].biDirectionalBool}</td>
        <td>${routes[i.index].excludeBool}</td>
        <td>${routes[i.index].originAirportSet}</td>
        <td>${routes[i.index].destinationAirportSet}</td>
      </tr>

  </c:forEach>
  </table>
</body>

</html>
