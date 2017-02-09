# 解答
数値が入ったListに対して、`stream()`メソッドを使用して、`Stream<Integer>`のストリームを取得する  
`Stream<Integer>`のストリームに対する中間操作として`filter()`メソッドを使用し、奇数を判定する`isOddNumber()`メソッドで奇数要素のみのストリームを作成する  
奇数要素のみのストリームに対する終端操作として`forEach()`メソッドを使用して、ストリームの各要素（奇数の値）を出力する

# 参考
http://docs.oracle.com/javase/jp/8/docs/technotes/guides/language/lambda_api_jdk8.html  
http://www.oracle.com/technetwork/jp/articles/java/architect-lambdas-part1-2080972-ja.html  
http://www.oracle.com/technetwork/jp/articles/java/architect-lambdas-part2-2081439-ja.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/List.html  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/Collection.html#stream--  
https://docs.oracle.com/javase/jp/8/docs/api/java/util/stream/Stream.html
