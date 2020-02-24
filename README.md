# Android_Kotlin_Lotto

## 2020년 2월 23일 노베이스 개발 시작

    ### 안드로이드 공부용

    ### 언어는 kotlin 으로 선정

    ### 주 기능은 로또 번호의 과거 당첨 내역 확인

    - constraint layout 으로 화면 구성
    - 로또 번호 입력 칸 및 예외 상황들에 대한 예외처리
    - 로또 공 이미지를 적용

## 2020년 2월 24일

    - 랜덤 번호 생성 버튼 추가 및 기능 구현
    - 초기화 버튼 생성 및 기능 구현
    - 이전까지의 로또 당첨번호를 api 를 이용해 가져와야 함
    - 데이터가 많아서 firebase 를 이용할 예정
    - firebase 추가 후 minSdkVersion 14 cannot be smaller than version 16 declared in library 빌드 오류 발생
    - app 단위 build.gradle 의 minSdkVersion 14 -> minSdkVersion 16 으로 수정해 해결
    - 나눔로또 api 로 각 회차의 정보를 받아올 수는 있지만 모든 회차를 탐색하려면 비효율적임
    - 동행복권에서 제곡하는 회차별 당첨정보 excel 파일을 JSON 형식으로 변환하는 방식을 시도할 예정