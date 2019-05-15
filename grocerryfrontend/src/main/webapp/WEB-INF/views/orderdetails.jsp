<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isELIgnored="false" %>
<jsp:useBean id="now" class="java.util.Date" />
<html>
<body>
<div class="navbar-header">
		<c:url value="resources/images/ast1.jpg" var="url"></c:url>
		<a class="navbar-brand" href=""><img src="${url }" alt="logo" height="50px" width="50px"></a>
			</div>
		
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order</h1>

            <p class="lead">Order confirmation</p>
        </div>

    
        <div class="container">
        <c:url value="/cart/confirm/${cartId }" var="url"></c:url>
<form:form action="${url }" modelAttribute="order">
            <div class="row">

                             <!-- <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3"> -->
                   <div>
                       <div class="txt-center">
                            <h1>Receipt</h1>
                       </div>
                       ORDER ID: ${order.orderId }
                  
                        <div class="row">
                             <div class="col-xs-6 col-sm-6 col-md-6">
                           
                                <address>
                                    <strong>Shipping Address</strong><br/>
                                    ${order.cart.customer.shippingaddress.streetname}
                                <br/>
                                    ${order.cart.customer.shippingaddress.city}, ${order.cart.customer.shippingaddress.state}
                                <br/>
                                   ${order.cart.customer.shippingaddress.zipcode}
                                </address>
                            </div>
                           <!--  <div class="col-xs-6 col-sm-6 col-md-6 text-right"> -->
                           <div>
                                <p>Shipping Date: ${order.purchaseDate }</p>
                            </div>
                        </div>

                        <div class="row">
                           <div class="col-xs-6 col-sm-6 col-md-6">
                          
                                <address>
                                    <strong>Billing Address</strong><br/>
                                        ${order.cart.customer.billingaddress.streetname}
                                    <br/>
                                        ${order.cart.customer.billingaddress.city}, ${order.cart.customer.billingaddress.state}
                                    <br/>
                                        ${order.cart.customer.billingaddress.zipcode}
                                </address>
                            </div>
                        </div>

                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <td>Image</td>
                                        <td>Product</td>
                                        <td>#</td>
                                        <td class="text-center">Price</td>
                                        <td class="text-center">Total</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:set var="grandTotal" value="0.0"></c:set>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                            <c:url value="/resources/images/${cartItem.product.id }.png" var="imgUrl"></c:url>
                                        <td><img src="${imgUrl }" height="40" width="50">  </td>
                                        <td class="col-md-9"><em>${cartItem.product.productname}</em></td>
                                        <td class="col-md-8" style="text-align: center">${cartItem.quantity}</td>
                                        <td class="col-md-8" style="text-align: center">${cartItem.product.price}</td>
                                        <td class="col-md-8" style="text-align: center">${cartItem.totalPrice}</td>
                                        <c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice }"></c:set>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total:</strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>$ ${order.cart.grandTotal}</strong></h4>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                            <input type="submit" value="Confirm">
                        </div>


                      
                    </div>
             
            </div>
            
            </form:form>
        </div>
</body>
<%@ include file="footer.jsp" %>
</html>