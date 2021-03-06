<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
  	* {box-sizing: border-box}
body {font-family: Verdana, sans-serif; margin:0}
.mySlides {display: none}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

.slide-btn {
	display: inline-block;
    min-width: 170px;
    height: 55px;
    color: #fff;
    border: 3px solid #fff;
    border-radius: 2px;
    padding: 0 30px;
    text-transform: uppercase;
    font-size: 14px;
    font-weight: 700;
    line-height: 49px;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .prev, .next,.text {font-size: 11px}
}
  </style>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<div class="slideshow-container">

<div class="mySlides fade">
  <img src="${pageContext.request.contextPath}/slide_dog.png" style="width:100%">
  <div class="text"><a href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>" class="slide-btn">분양하러가기</a></div>
</div>

<div class="mySlides fade">
  <img src="${pageContext.request.contextPath}/slide_cat.png" style="width:100%">
  <div class="text"><a href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>" class="slide-btn">분양하러가기</a></div>
</div>

<div class="mySlides fade">
  <img src="${pageContext.request.contextPath}/slide_fish.png" style="width:100%">
  <div class="text"><a href="<c:url value="/shop/viewCategory.do?categoryId=FISH"/>" class="slide-btn">분양하러가기</a></div>
</div>

<div class="mySlides fade">
  <img src="${pageContext.request.contextPath}/slide_reptile.png" style="width:100%">
  <div class="text"><a href="<c:url value="/shop/viewCategory.do?categoryId=REPTILE"/>" class="slide-btn">분양하러가기</a></div>
</div>

<div class="mySlides fade">
  <img src="${pageContext.request.contextPath}/slide_bird.png" style="width:100%">
  <div class="text"><a href="<c:url value="/shop/viewCategory.do?categoryId=BIRD"/>" class="slide-btn">분양하러가기</a></div>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span>
  <span class="dot" onclick="currentSlide(4)"></span>
  <span class="dot" onclick="currentSlide(5)"></span>
</div>

<div style="margin-left:350px">
<p><i class="fa fa-fire" style="font-size:24px;color:#ff0000"></i><b> 핫한 경매상품 </b></p>
</div>
<div class="row">
  <div class="col-sm-2"></div>
<c:forEach var="hotItem" items="${item}">
<div class="col-xs-6 col-md-3">
    <div class="thumbnail">
      <img class="img-thumbnail" src="${pageContext.request.contextPath}/images/${hotItem.image}" width="242" height="200">
      <div class="caption">
        <h3>${hotItem.name}</h3>
                  <font size="2"><b>경매 상품 입니다.</b></font><br />
                  <c:if test="${hotItem.status.equals('OPEN') }">
                     <font size="2"><b>경매가 진행중입니다.</b></font><br />
                  </c:if>
                  <c:if test="${hotItem.status.equals('CLOSE') }">
                     <font size="2"><b>경매가 종료되었습니다.</b></font><br />
                  </c:if>
        <font size="2" color="#0ba360">판매자:</font><font size="2">${hotItem.username }</font>
        <br /><br />
        <p>

                  <a href='<c:url value="/shop/viewAuctionItem.do">
                     <c:param name="itemId" value="${hotItem.itemId}"/></c:url>' class="btn btn-primary" role="button">구매하기</a></p>
      </div>
  </div>
</div>
      </c:forEach>
<br />
</div>



<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}

var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1} 
    slides[slideIndex-1].style.display = "block"; 
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>