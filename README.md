# spabbitecomm

```bash
mvn clean install
DOCKER_HOST=unix:///var/run/docker.sock mvn docker:build
(mvn docker:build #Windows build image)
cd docker
docker-compose up
docker-compose rm -v
cd ..
```


```bash
<!-- create iPhone product -->
$ curl -v --header "Content-Type: application/json" --header "Accept: */*" "http://127.0.0.1:7000/products" -d '{"id":"1","name":"iPhone X","quantity":"200","unitPrice":"1500.00"}'
<!-- search iPhone product -->
$ curl -v "http://127.0.0.1:9200/product/generic/_search?q=name:iphone&pretty=true"
<!-- create Huawei product -->
$ curl -v --header "Content-Type: application/json" --header "Accept: */*" "http://127.0.0.1:7000/products" -d '{"id":"2","name":"Huawei Mate Pro 10","quantity":"200","unitPrice":"1300.00"}'
<!-- create an order -->
$ curl -v --header "Content-Type: application/json" --header "Accept: */*" "http://127.0.0.1:7050/orders" -d '{"comment":"order comment 1", "lineItems":[{"productId":"1","quantity":"5"},{"productId":"2","quantity":"8"}]}'
```
```bash
docker exec -it my-mysql mysql -h localhost -u root -p
```````````