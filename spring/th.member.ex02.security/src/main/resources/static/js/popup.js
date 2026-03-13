// 1. 필요한 요소 선택
       const popup = document.getElementById("layerPopup");
       const closeBtn = document.getElementById("closePopup");
       const weekCheck = document.getElementById("weekClose"); // 체크박스 참조

       /**
        * 2. 날짜 처리
        * today: 현재 시점의 날짜 (예: "2026-03-09")
        */
       const today = new Date().toISOString().slice(0, 10);

       /**
        * 3. 로컬 스토리지에서 '숨김 만료일' 조회
        * 이전에 저장된 "2026-03-16" 같은 날짜 문자열이 있는지 확인합니다.
        */
       const hideUntil = localStorage.getItem("hidePopupUntil");

       /**
        * 4. 팝업 표시 로직 (날짜 비교)
        * hideUntil이 존재하고, 오늘(today)이 저장된 날짜(hideUntil)보다 작거나 같다면 숨깁니다.
        * 예: 오늘이 9일인데, 16일까지 숨기기로 되어 있다면 조건 충족 -> 숨김.
        */
       if (hideUntil && today <= hideUntil) {
           popup.style.display = "none";
       } else {
           popup.style.display = "block";
       }

       /**
        * 5. 닫기 버튼 클릭 이벤트
        */
       closeBtn.addEventListener("click", () => {
           // 체크박스가 선택되어 있다면
           if (weekCheck.checked) {
               /**
                * 6. 7일 후의 날짜 계산
                * 현재 날짜 객체를 생성한 뒤, .getDate() + 7을 통해 일주일 후로 세팅합니다.
                */
               const date = new Date();
               date.setDate(date.getDate() + 7);

               // 계산된 7일 후 날짜를 "YYYY-MM-DD" 포맷으로 변환
               const hideUntilDate = date.toISOString().slice(0, 10);
               
               // 로컬 스토리지에 '이 날짜까지는 숨겨줘'라고 저장
               localStorage.setItem("hidePopupUntil", hideUntilDate);
           }
           
           // 팝업 닫기
           popup.style.display = "none";
       });