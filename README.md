# 초성검색 서치라임

Playstore 에 배포되어있는 어플리케이션 서치라임의 소스코드입니다.
https://play.google.com/store/apps/details?id=com.biggerThanGreater.willy.rhymer

## MainActivity.java
MainActivity 파일 내에 대부분의 주요 알고리즘이 구현되어있습니다.
Unicode 기반 국어단어의 초성/중성/종성으로 분류하여 API 서버에 요청을 보냅니다.


## PHP API server
API 서버는 PHP 서버로 따로 구성되어있습니다.
국어단어들을 초성/중성/종성별 Indexing 후 검색속도를 최적화해놓았습니다


### powered by NiaDIC 
국어단어는 한국정보화진흥원 NiaDIC을 기반으로 검색합니다.
