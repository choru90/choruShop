# choruShop

- 목적 : EC 사이트를 개발 하면서 여러가지 기능 개발 및 구조 개선 등을 통해서 장단점을 알아가는것
- usecase를 만들어서 각 도메인간 연관관계(JPA)에 묶이지 않고 도메인이 의존관계를 좀더 줄일 수 있도록 개발을 진행

# 목표
- 회상, 상품, 주문 기능 구현
- 이벤트가 있음을 가정하고 주문량을 늘려서 트랙픽을 생성해보고 대응 해보기
- MSA 형태를 spring cloud를 사용해서 변경해보기
- kafka를 통해서 도메인간 싱크를 맞춰보기

  
# 1차 목표
- 회사, 상품, 주문 기능 구현 : 회사가 상품을 등록하고 유저가 상품을 주문하도록 기능 개발
- controller, usecase, service, repository로 구분하여서 개발
## release record
- 회사 CRUD 개발 완료 (2023-06-13)
- 회사 등록 API 테스트 코드 추가(2023-06-18)
- 회사 수정, 삭제 API 테스트 코드 추가(2023-06-19)
- Exception Handler 추가(2023-06-19)
- 상품 domain 생성(2023-06-22) - controller, usecase, service의 구조를 어떻게 가져가야할지 고민이 필요함 => controller, usecase, service, repository로 구분하여서 개발
  => service내에서 JPA 연관관계로 묶여서 결합도가 높은 형태에서 각 도메인별로 필요의 데이터만 주고 받는 usecase를 사용해보기로함
- 상품 등록 API 개발, 회사 통합테스트코드(IT)의 범위를 각 API를 호출하는 범위로 mocking이 아닌 실제 repository에서 실행되어지는지 확인하도록 변경(2023-06-23)
- 상품 조회, 목록 조회, 수정, 삭제 API 추가(2023-06-27)
