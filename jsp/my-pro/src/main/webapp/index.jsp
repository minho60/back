<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>	

<!DOCTYPE html>
<html>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="/view/common/favicon.png">
  <link rel="stylesheet" href="/static/assets/css/main.css">
  <title>SUBWAY 써브웨이</title>
<body>

	<%@ include file="view/common/header.jsp" %>
	
	<!-- section(본문) area -->
	<div id="sec1" class="sec">
		<div class="vid">
			<video autoplay muted loop>
				<source src="static/assets/vid/vid.mp4" type="video/mp4" />
			</video>
		</div>
		<div class="ele-center">
			<div class="container">
				<h2>SEARCH FOR BETTER</h2>
				<p>우리는 더 좋은 써브웨이를 위해 매일 노력합니다.</p>
				<ul class="counter">
					<li><span>60</span> <span>년</span>
						<div>함께한 시간</div></li>
					<li><span>656</span> <span>개</span>
						<div>가맹점 수</div></li>
					<li><span>3,589,812</span> <span>명</span>
						<div>써브웨이 (App 누적 가입자)</div></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- #sec1 -->

	<!-- section2 area -->
	<!-- https://www.honorsville.co.kr/ -->
	<div id="sec2" class="sec">
		<div class="container ele-center">
			<div class="card-list ele-center">
				<!-- card-container -->
				<div class="card-container">
					<!-- card-image-wrapper -->
					<div class="card-image-wrapper">
						<!-- https~, http~ : 절대주소 -->
						<img src="static/assets/img/bg_utilization.png" alt="써브웨이를 제대로 즐기는 방법"
							class="card-image" />
					</div>
					<!-- .card-image-wrapper -->
					<!-- card-content -->
					<div class="card-content">
						<div class="card-body">
							<h3 class="card-title">
								써브웨이를<br />제대로 즐기는 방법
							</h3>
							<div class="card-details">
								<p>메뉴를 고르세요. 샌드위치(15cm 또는 30cm)와 샐러드 중 선택 가능합니다.</p>
								<p>이용 방법을 누르면 자세한 사항을 확인할 수 있습니다.</p>
							</div>
							<div class="card-link">
								<a href="#" class="tag-badge">이용방법</a>
							</div>
							<!-- .card-contact -->
						</div>
					</div>
					<!-- .card-content -->
				</div>
				<!-- .card-container -->
				<div class="card-container">
					<!-- card-image-wrapper -->
					<div class="card-image-wrapper">
						<img src="static/assets/img/history.png" alt="my subway history"
							class="card-image">
					</div>
					<!-- .card-image-wrapper -->
					<!-- card-content -->
					<div class="card-content">
						<div class="card-body">
							<h3 class="card-title">
								50년 역사를 가진<br />No.1 프랜차이즈의 성장기
							</h3>
							<div class="card-details">
								<p>1965년 17세 사업가, 프레드 델루카 Pete’s Super Submarines 오픈 (미국,
									코네티컷) ...</p>
								<p>써브웨이 역사가 궁금하시면 "서브웨이 역사" 버튼을 눌려주세요.</p>
							</div>
							<div class="card-link">
								<a href="#" class="tag-badge">서브웨이 역사</a>
							</div>
							<!-- .card-contact -->
						</div>
					</div>
					<!-- .card-content -->
				</div>
				<!-- .card-container -->
				<div class="card-container">
					<!-- card-image-wrapper -->
					<div class="card-image-wrapper">
						<ul class="latest">
							<li><a href="#">고객 사과문</a></li>
							<li><a href="#">고객 사과문 및 랍스터 컬렉션 모바일 상품권 안내</a></li>
							<li><a href="#">써브웨이와 함께하는 tvN 월화드라마 '얄미운 사랑'</a></li>
							<li><a href="#">썹 카드 유효기간 및 연장 안내</a></li>
						</ul>
					</div>
					<!-- .card-image-wrapper -->
					<!-- card-content -->
					<div class="card-content">
						<div class="card-body">
							<h3 class="card-title">
								써브웨이의 다양한 소식을<br> 빠르게 전달해드립니다.
							</h3>
							<div class="card-details">
								<p>현재 총 195건의 게시글이 있습니다.</p>
								<p>써브웨이의 최신 정보를 확인하시려면 "What's New" 버튼을 눌려주세요.</p>
							</div>
							<div class="card-link">
								<a href="#" class="tag-badge">What's New</a>
							</div>
							<!-- .card-contact -->
						</div>
					</div>
					<!-- .card-content -->
				</div>
				<!-- .card-container -->
			</div>
			<!-- .card-list -->
		</div>
		<!-- .container -->
	</div>
	<!-- #section -->

	<!-- section3 area -->
	<div id="sec3" class="sec">
		<div class="intro">
			<h2>
				<span>pick</span><span>your</span><span>favorite</span>
			</h2>
			<p>
				<b>다양한 드라마</b>를<br>
				<strong>써브웨이</strong>와 함께 즐겨보세요
			</p>
			<p>
				써브웨이만의 특별함을 경험할 수 있는 최상의 선택 <b>음료</b><br> 써브웨이 커피와 완벽한 어울림을
				자랑하는 <b>푸드</b><br> 다양한 시도와 디자인으로 가치를 더하는 <b>상품</b><br> 소중한
				사람에게 마음을 전하는 가장 좋은 방법 <b>써브웨이 카드</b>
			</p>
			<a href="#">자세히 보기</a>
		</div>
		<div class="product">
			<img src="static/assets/img/picks.png" alt="product">
		</div>
	</div>
	<%@ include file="view/common/footer.jsp" %>
	
</body>
</html>