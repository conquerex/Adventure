![모험을 떠나자](https://raw.githubusercontent.com/conquerex/Adventure/5521f5786ba0ccc0c05ea01f08ad979fa7f2873d/Chap02_ViewForest_View/app/src/main/res/drawable/37474696_p0.jpg)

# Adventure at Android
Android World로 여행을 떠난 어떤 모험가의 이야기.


## 여행기 작성법

0. `안드로이드 프로그래밍 정복`이라는 여행서를 가이드삼아 떠난다.
1. 아직 마왕이 누군지도 모른다.
2. 무기 및 장비는 챕터별로 얻을 수 있다. (뷰, 레이아웃 등)
3. 모험가 학원을 다녀온 상태라 Lv.10에서 시작한다.

---


## Chap.01 Basecamp

- 안드로이드 세계를 알고 싶어서 시작한 모험
- 그런데 실수로 온 베이스캠프는 초보 모험가의 마을이 아니었다.
- 고수들이 모이는 마을. `RxAndroid`.
- 장비(개발환경) 테스트 겸 왔다고 하자.
```
안드로이드 경험치 : (+ 50) 50
```


## Chap.02 View Forest

- 뷰 숲에는 많은 몬스터(Object)들이 살고 있다.
- 버튼, 이미지뷰, 텍스트뷰... 이들을 모두 `뷰(View)`라고 부른다.
- 이런 뷰를 정의해서 자유롭게 소환할 수 있다.
```
안드로이드 경험치 : (+ 50) 100
View 소환술을 습득하였습니다.
```


## Chap.02-1 Layout Forest

- 복잡한 Layout을 잘 다룰 수 있어야 한다.
  - LinearLayout, FrameLayout, RelativeLayout
- 코드에서 레이아웃을 만들어 줄 수 있다.
- Inflation(전개)를 통해 특정뷰를 가져오기
- 레이아웃 파라미터를 물리쳤다.
```
안드로이드 경험치 : (+ 100) 200
inflate 소환술을 습득하였습니다.
layout 갑옷을 착용하였습니다
```


## Chap.03 Output Village

- Custom View를 사용해본다.
- Paint는 구경만 했다.
- 화가, `Bitmap`과 만났다.
- Bitmap의 친구들(텍스트, Path). 셰이더(Shader)는 만나지 않았다.
- Toast, SoundPool, Audio와 만났다.
- 만나기 까다로운 `Permission`을 만났다.
  - Permission은 [6.0 마시멜로우 권한체크](http://gun0912.tistory.com/55)를 알려주었다.
  - 마법 발동 과정 중 onRequestPermissionsResult()이 이해가 가지 않는다.
  - 위 이슈의 원인 파악이 되었다. 두 개의 장비 중 하나가 6.0 미만이었음을 늦게 깨달아서 마을을 늦게 떠나게 되었다.
  - onRequestPermissionsResult에 대해 대화하였다.
```
안드로이드 경험치 : (+ 100) 300
6.0 마시멜로우 권한체크를 습득하였습니다.
퍼미션 정책서를 습득하였습니다.
```


## Chap.04 Event River

- Event 강에서 하류로 가는 배를 탔다.
- 강에서 리스너를 낚았다.
- 낚은 리스너로 이벤트 처리를 하여 요리를 하였다.
- 핸들러를 순서대로 요리하였다.
- 요리할 때, 외부 변수를 조미료로 썼다.
- 여러가지 요리를 만들었다.
  - Touch 구이, Keycode탕, onClick찜
- 하류에 무사히 도착하였다.
```
안드로이드 경험치 : (+ 100) 400
```


## Chap.05 Menu Port

- Menu 항구에 들어갔다.
```
안드로이드 경험치 : (+ 10) 410
```


## Chap.?? Fragment Sword

- Activity Sword보다 작지만 유용하다
- 여러 Activity와 겸용(재사용)이 가능하다
- `Fragment`끼리 영향을 주기 위해서는 Activity를 경유하는 것이 좋다
- Activity와 유사한 생명주기를 가진다.
- 이후 더 자세히 다루기로 한다. (2016.11.16)
