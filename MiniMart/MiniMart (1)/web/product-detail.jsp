<%-- 
    Document   : product-detail
    Created on : Apr 28, 2023, 9:42:58 AM
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
    <title>Product</title>
    <link rel="stylesheet" href="css/product.css">
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
        <!-- motasanpham -->
        <div class="motasanpham">
            <!-- left -->
            <div class="left">
                <div class="anhto"><img src="${product.productImg}" alt=""></div>
                <ul>
                    <li><img src="${product.productImg}" alt=""></li>
                    <li><img src="${product.productImg}" alt=""></li>
                    <li><img src="${product.productImg}" alt=""></li>
                    <li><img src="${product.productImg}" alt=""></li>
                    <li><img src="${product.productImg}" alt=""></li>
                </ul>
            </div>
            <!-- /left -->
            <!-- main -->
            <div class="main">
                <h1>${product.productName}</h1>
                <div class="xuatxu">
                    <p><b>Xuất xứ:</b> ${product.origin}</p>
                </div>
                <div class="gia">
                    <h1>${product.price}đ</h1>
                </div>
                <div class="gioithieu">
                    <ul>
                        <li><p>${product.description_1}</p></li>
                        <li><p>${product.description_2}</p></li>
                        <li><p>${product.description_3}</p></li>
                    </ul>
                </div>
                <div class="soluong">
                    <p>Số lượng:</p>
                    <button>
                        <p>1</p>
                    </button>
                </div>
                
                <div class="dathang">
                <button>
                        <p>
                        Thêm vào giỏ hàng
                        </p>
                    </button>
                    <button>
                        <p>Gọi ngay đặt hàng</p>
                    </button>
                </div>
            </div>
            <!-- /main -->
            <!-- right -->
            <div class="right">
                <ul>
                    <li><img src="images/service_product_1.webp" alt=""><p>Giao hàng miễn phí</p></li>
                    <li><img src="images/service_product_2.webp" alt=""><p>Tích điểm đổi quà</p></li>
                    <li><img src="images/service_product_3.webp" alt=""><p>100% an toàn thực phẩm</p></li>
                    <li>
                        <img src="images/service_product_4.webp" alt="">
                        <p>
                        Tư vấn 8/24
                        </p>
                    </li>
                </ul>
            </div>
            <!-- /right -->
        </div>
        <!-- /motasanpham -->
         <!-- san pham -->
         <!-- thongtinsanpham -->
         
         <!-- /thong tin san pham -->
        <div class="sanphamto">
            
            <div class="sanpham">
                <!-- sanphambanchay -->
                <div class="sanphambanchay">
                    <a href="">
                        <h1> Sản phẩm cùng loại</h1>
                    </a>
                    <div class="mathang">
                        <ul>
                            <c:forEach items="${listP}" var="p">
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
               
            </div>
        </div>
        <!-- /sanpham -->
      
        
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