![image](https://user-images.githubusercontent.com/66408194/134773279-98695b2a-a5c9-499c-8e32-d2336a378fba.png)
#### MainActivity에 ClientID와 ClientSecret을 변수로 제공했습니다.
#### 제공을 위해 MainActivity에 위치한 부분이라 이후 마음껏 수정하셔도 됩니다.

<br>

<br>

## 브랜치 나누기
![image](https://user-images.githubusercontent.com/66408194/134773920-3e17b04f-cf55-44d9-b255-640c49f78f0b.png)

1. Chapter1의 경우 : 이미지처럼 반드시 <b>마스터</b>를 기반으로 둔 다음 id-chapter1로 생성(dev-donghwan-chapter1) 후 Fork한 뒤 진행
2. Chapter2의 경우 : <b>Chapter1</b> 브랜치에서 이미지처럼 id-chapter2(dev-donghwan-chapter2)로 생성하여 Fork한 뒤 진행

<br>

<br>

## 공통 사용 조건
### 1. MVVM 사용
### 2. Android AAC 사용 (Room은 제외)
### 3. Contraint Layout만 사용
### 4. Retrofit 사용
### 5. Glide 사용

<br>

<br>

# Chapter 1 요구사항 

1. 화면과 같은 Layout을 구성하세요
2. 검색 버튼을 누르면 리스트에 출력하도록 하세요 (아이템의 높이는 100dp~150dp)
3. 출력할 데이터는 이미지, 제목, 평점 항목만 표시하세요 (정보를 무리하게 다듬으려고 하지말고 출력이 되면 Ok)
4. 검색 결과 출력된 리스트의 아이템을 클릭하면 해당 아이템의 정보를 출력하는 상세 화면을 구현하세요
5. 상세 화면에는 이미지, 제목, 평점, 감독, 배우까지 출력하세요 (레이아웃은 이쁘게할 필요 없고 정보만 나오면 Ok)
6. 어떠한 경우에도 findViewById는 절대 사용 금지
7. by viewModels() 절대 사용 금지
8. BindingAdapter는 자율적으로 사용하세요

<br>

<br>

# Chapter 2 요구사항

1. 검색버튼 우측에 검색기록 버튼을 추가하세요
2. 검색기록 버튼을 누르면 새로운 화면에 가장 최근 검색했던 검색어를 최신순으로 5개 보여주세요 (중복 허용X)
3. 검색어를 클릭하면 메인화면에 해당 검색어로 검색한 결과가 나타나도록 하세요
4. 검색결과가 없을 경우 아래 이미지처럼 처리하기
5. 검색결과에 Loading 중 Dim 처리
6. 검색 Error에 대해 오류가 발생했습니다. 팝업 띄워서 사용자에게 인지시키기 (세부 분기 필요X)
7. 반드시 Repository Pattern 사용하기
8. 반드시 BindingAdapter 사용하기

![image](https://user-images.githubusercontent.com/66408194/134773785-9acae64f-effd-4a8c-be70-08fb1f5cce56.png)
