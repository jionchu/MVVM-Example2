# 🎥 MVVM 예제 - 영화 검색 앱
> 개발 기간: 2021.10.01 - 2021.10.16

MVVM 패턴을 적용한 간단한 영화 검색 어플리케이션입니다.
1. 제목을 입력해 원하는 영화를 검색할 수 있습니다.
2. 검색한 영화 아이템을 클릭해 상세 정보를 확인할 수 있습니다.
3. 검색 기록을 저장하여 최근 검색어 5개를 확인할 수 있습니다.
4. 최근 검색어를 클릭해 해당 검색어의 검색 결과를 확인할 수 있습니다.

## 🛠️ Stack & Libraries
- Kotlin
- MVVM 아키텍처 패턴
- AAC(LiveData, ViewModel)
- DataBinding
- Retrofit2: 서버 통신
- Okhttp3: interceptor (header 자동 추가)
- Gson: json parser
- Glide: 이미지 처리
- Parcelize: Parcelable 자동 구현

## ✨ Screenshots
| 메인 화면 - 영화 검색 시 | 메인 화면 - 검색 결과가 없는 경우 |
| :-----------------: | :-----------------------: |
| <img src="https://user-images.githubusercontent.com/40855422/137578261-f5a889ad-c6e7-438c-9120-ec8c6fdb7ef7.png" width="300"/> | <img src="https://user-images.githubusercontent.com/40855422/136636591-714dc7d4-d120-428f-9fbe-9fb79abb023e.png" width="300"/> |

| 영화 상세 정보 화면 | 검색 기록 화면 |
| :------------: | :---------: |
| <img src="https://user-images.githubusercontent.com/40855422/137578235-fd42dc29-3cf0-4db9-bbee-f22d5e235cc0.png" width="300"/> | <img src="https://user-images.githubusercontent.com/40855422/136636654-f9416f3d-3769-47ee-ad47-b01ab5bc658c.png" width="300"/> |

## :gear: Development Environment
- Android Studio - Arctic Fox | 2020.3.1
- minSdkVersion : 24
- targetSdkVersion : 31
