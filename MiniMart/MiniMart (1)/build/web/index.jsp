<%-- 
    Document   : index
    Created on : Apr 28, 2023, 9:42:36 AM
    Author     : TT
--%>

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
            <div class="banner-left">
                <img src="images/logo.png" alt="">

            </div>
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

                    <li><a href="#">Danh sách ưu thích</a></li>
                    <li><a href="">Đăng kí</a>
                        <a href="">Đăng nhập</a>
                    </li>
                </ul>
                <button class="giohang">
                    <p>GIỎ HÀNG</p>
                </button>

            </div>
            <!-- /banner right -->

        </div>
        <!-- /banner -->
        <!-- backgdop -->
        <div class="backdrop">
            <img src="images/slider_1.jpg" alt="">
        </div>

        <!-- /backdrop -->
        <!-- san pham -->
        <div class="sanphamto">
            <div class="sanpham">
                <div class="chivoi">
                    <ul>
                        <li><a href=""> <img src="images/banner_1.jpg" alt=""></a></li>
                        <li><a href=""><img src="images/banner_2.jpg" alt=""></a></li>
                        <li><a href=""><img src="images/banner_3.jpg" alt=""></a></li>
                    </ul>
                </div>
                <!-- sanphambanchay -->
                <div class="sanphambanchay">
                    <a href="">
                        <h1>Sản phẩm mới nhất</h1>
                    </a>
                    <div class="mathang">
                        <ul>
                            <c:forEach items="${listNew}" var="p">
                                <li>
                                    <a href="product-detail?pid=${p.id}">
                                        <img src="${p.productImg}" alt="">
                                    </a>
                                    <div class="tensp">
                                        <h3>${p.productName}</h3>
                                        <div>${p.price}đ</div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        <ul>
                            <c:forEach items="${listNew1}" var="p">
                                <li>
                                    <a href="product-detail?pid=${p.id}">
                                        <img src="${p.productImg}" alt="">
                                    </a>
                                    <div class="tensp">
                                        <h3>${p.productName}</h3>
                                        <div>${p.price}đ</div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- /sanphanban chay -->
                <!--Đồ khô  -->
                <div class="dokho">
                    <a href="category?cid=${1}&amp;page=${1}">
                        <h1>${category1.categoryName}</h1>
                    </a>
                    <div class="mathang">
                        <ul>
                            <c:forEach items="${listC1}" var="i">
                                <li>
                                    <a href="product-detail?pid=${i.id}">
                                        <img src="${i.productImg}" alt="">
                                    </a>
                                    <div class="tensp">
                                        <h3>${i.productName}</h3>
                                        <div>${i.price}đ</div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        
                    </div>
                </div>
                <!-- /đồ khô -->
                <!-- hoa quar -->
                <div class="dokho">
                    <a href="category?cid=${2}&amp;page=${1}">
                        <h1>${category2.categoryName}</h1>
                    </a>
                    <div class="mathang">
                        <ul>
                            <c:forEach items="${listC2}" var="i">
                                <li>
                                    <a href="product-detail?pid=${i.id}">
                                        <img src="${i.productImg}" alt="">
                                    </a>
                                    <div class="tensp">
                                        <h3>${i.productName}</h3>
                                        <div>${i.price}đ</div>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        
                    </div>
                </div>
                <!-- haoqua -->
            </div>
        </div>
        <!-- /sanpham -->
        <!-- Xem theo danh muc -->
        <div class="danhmuc">
            <div class="danhmucnho">
                <a href=""><h1>Xem theo danh mục</h1></a>
                <ul>
                    <c:forEach items="${listC}" var="c">
                        <li><a href="category?cid=${c.id}&amp;page=${1}"><p>${c.categoryName}</p><img src="${c.categoryImg}" alt=""></a></li>
                    </c:forEach>
                </ul>
            </div>
            
        </div>
        <!-- /xem theo danh muc -->
        <!-- meo hay su dung -->
        <div class="meohaysudung">
            <h1>Mẹo hay sử dụng</h1>
            <div class="body">
                <ul>
                    <li><img src="images/bi-quyet-chon-mua-trai-cay-khong-co-hoa-chat-bao-quan-5.jpg" alt="">
                        <div>
                            <a href="">
                                <b>Bí quyết bảo quản nho đen trong tủ lạnh tươi lâu hơn</b>
                            </a>
                            <p>Bí quyết lựa chọn và bảo quản nho tươi – Nho rất ngon và tốt cho sức khỏe, tuy nhiên nếu không biết cá</p>
                        </div>
                    </li>
                    <li><img src="images/fruits-buyers-russia.jpg" alt=""><p></p>
                        <div>
                            <a href=""><b>Công dụng của chanh ngâm mật ong chữa ho hiệu quả</b></a>
                            <p>Chắc bạn đã biết, cả chanh và mật ong đều là những nguyên liệu quý bởi những công năng, tác dụng củ</p>
                        </div>
                    </li>
                    <li><img src="images/trangloc-rau.jpg" alt=""><p></p>
                        <div>
                            <a href=""><b>Những loại trái cây Nhật đắt như vàng ròng đổ bộ về Việt</b></a>
                            <p>Nhật Bản là đất nước có nhiều loại hoa quả có chất lượng thuộc hàng ngon nhất thế giới nhưng cũng vô</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /meo hay su dung -->
        <!-- footer -->
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
