<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BTVN</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/order-detail.css">
    <link rel="stylesheet" href="css/update.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
</head>

<body>
    <!-- wraper -->
    <div class="wraper">
        <!-- header -->
        <div class="header">
            <ul>
                <li><i class="fa fa-check" aria-hidden="true"></i><a href="">Giá cả nhiều ưu đãi khi mua hàng</a></li>
                <li><i class="fa fa-plane" aria-hidden="true"></i></i><a href="">Giao hàng miễn phí và nhanh chóng</a></li>
                <li><i class="fa fa-star" aria-hidden="true"></i><a href="">Sản phẩm đa dạng và có kiểm định</a></li>
            </ul>
        </div>

        <!-- /header -->
        <!-- banner -->
        <div class="banner">
            <!-- banner left -->
            <a href="home">
                <div class="banner-left">
                    <img src="images/logo.png" alt="">
                </div>
            </a>
            
            <!-- /banner left -->
            <!-- banner main -->
            <div class="banner-main">
                <div class="timkiem">
                    <form action="search" method="post">
                        <div class="xxx" style="display: flex;">
                            <input type="text" placeholder="Tìm kiếm tại đây" name="searchtxt">
                            <button><p>tìm kiếm</p></button>
                        </div>
                    </form>
                    <ul>
                        <li>
                            <a href="">Bán chạy nhất</a>
                        </li>
                        <li> <a href="">Mua nhiều nhất</a></li>
                        <li><a href="">Giảm giá</a></li>
                    </ul>
                </div>
                
            </div>
            <!-- /banner main -->
            <!-- banner right -->
            <div class="banner-right">
                <ul>
                    <c:if test="${sessionScope.account.role_id == 2}">
                        <li><a href="#">Trang admin</a></li>
                    </c:if>
                    <c:if test="${sessionScope.account == null}">
                        <li>
                            <a href="signup.jsp">Đăng kí</a>
                            <a href="login.jsp">Đăng nhập</a>
                        </li>
                    </c:if>   
                    <c:if test="${sessionScope.account != null}">
                        <li>
                            <a>Hello ${sessionScope.account.userName}</a>
                            <a href="logout">Đăng xuất</a>
                        </li>
                    </c:if>   
                </ul>
                <form action="cart" method="get">
                    <button class="giohang">
                        <p>GIỎ HÀNG</p>
                    </button>
                </form>
            </div>
            <!-- /banner right -->

        </div>
        <!-- /banner -->
        <!-- backgdop -->
        <div class="container">
            <div class="order-detail">
                <h2>Chi tiết đơn hàng</h2>
                <table>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Tổng cộng</th>
                    </tr>
                    <c:forEach items="${listI}" var="i">
                         <tr>
                            <td>${i.product.getProductName()} x${i.count}</td>
                            <td>${i.product.getPrice() * i.count}đ</td>
                        </tr>
                    </c:forEach>
                   
                    
                    <tr>
                        <td>Tổng cộng</td>
                        <td>${totalPay}đ</td>
                    </tr>
                </table>
            </div>
            <div class="user-info">
                <p class="title">Thông tin nhận hàng</p>
                <ul class="user-detail">
                    <li class="detail-item">Tên người nhận: ${newOrder.receiver}</li>
                    <li class="detail-item">Địa chỉ: ${newOrder.address}</li>
                    <li class="detail-item">Số điện thoại: ${newOrder.phone}</li>
                    <li class="detail-item">Tổng chi phí: ${totalPay}đ</li>
                </ul>
            </div>
        </div>
        <footer>
            <ul>
                <li>
                    <a href=""><img src="images/logo_footer.png" alt=""></a>
                    <p>Siêu thị MiniMart cung cấp các mặt hàng siêu sạch đem lại sức khỏe cho bạn</p>
                    <div class="diachi">
                        <img src="images/i_footer_1.png" alt=""> 
                        <p>Tầng 6 Ladeco, 266 Đội Cấn, Hà Nội,</p>
                    </div >
                    <div class="sdt">
                        <img src="images/i_footer_2.png" alt="">
                        <a href="">1900 6750</a>
                    </div>
                    <div class="gmail">
                        <img src="images/i_footer_3.png" alt="">
                        <a href="">support@sapo.vn</a>
                    </div>
                </li>
                <li class="x2">
                    <h2>Tài khoản</h2>
                    <a href=""><p>Trang chủ</p></a>
                    <a href=""><p>Sản phẩm</p></a>
                    <a href=""><p>Giới thiệu</p></a>
                    <a href=""><p>Tin tức</p></a>
                    <a href=""><p>Liên hệ</p></a>
                </li>
                <li class="x2">
                    <h2>Hỗ trợ khách hàng</h2>
                    <a href=""><p>Trang chủ</p></a>
                    <a href=""><p>Giới thiệu</p></a>
                    <a href=""><p>Sản phẩm</p></a>
                    <a href=""><p>Tin tức</p></a>
                    <a href=""><p>liên hệ</p></a>
                </li>
                <li class="x2">
                    <h2>Gửi Email</h2>
                    <p>Gửi email nhận khuyến mãi</p>
                    <button>
                        <p>Email của bạn</p>
                        <div>
                            <a href=""><p>Gửi</p></a>
                        </div>
                    </button>
                    <div class="logo">
                        <img src="images/logo-mxh.jpg" alt="">
                    </div>
                </li>
            </ul>
            <ul class="banquyen">
                <li class="x3"><p>Bản quyền thuộc về Cafein Team</p></li>
                <li class="x3"><p> Cung cấp bởi Sapo</p></li>
            </ul>
        </footer>
        <!-- footer -->
    </div>
    <!-- /wraper -->
</body>

</html>
