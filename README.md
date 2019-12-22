# 3주차 - 블랙잭
**우아한 테크코스 2기 미션 복습**

# 기능 목록
* 게임에 참여할 사람의 이름을 입력한다.
    * 쉼표 기준으로 분리한다.
    * [**예외**] 이름이 비어있다.
    * [**예외**] 이름에 공백이 존재한다.
    * [**예외**] 같은 이름이 존재한다.
* 베팅 금액을 입력받는다.
    * [**예외**] 베팅 금액이 0 이하이다.
* 카드 덱을 섞는다
* 카드 덱에서 카드 한 장을 뽑는다.
* 딜러가 카드를 한 장 나눠준다.
* 카드의 합을 계산한다.
    * Ace 카드는 1 또는 11로 계산한다.
* 가지고 있는 카드가 블랙잭인지 판단한다.
* 가지고 있는 카드가 버스트인지 판단한다.
* 블랙잭 게임 흐름
    * 딜러는 모든 플레이어와 자신에게 카드 두 장을 나눠준다.
    * 딜러는 카드의 합이 16이하면 카드 한 장을 추가로 받는다.
    * 카드를 한 장 더 추가할지 입력한다.
        * 카드 합이 21미만이면 몇 장이든 추가할 수 있다.
        * [**예외**] y 또는 n을 입력하지 않았다.
    * 최종 수익을 계산한다.
        * 플레이어가 블랙잭인 경우 베팅 금액의 1.5배를 받는다.
        * 딜러가 블랙잭인 경우 블랙잭인 플레이어는 베팅한 금액을 돌려 받는다.
    