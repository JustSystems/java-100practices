[問題](../README.md)

***
# 072：解答例
## 問題点
1. エラーが発生した場合のリクエストコードが設定されていない。
2. MVCモデルにおいて、Controllerにメソッドや処理などのロジックを実装するのは望ましくない。
MVCモデルのデザインパターンに沿ってクラスを作成していく必要がある。

## 各クラスの説明（実装例）
[Knock072.java](src/Knock072.java) : サーブレットに関する`controllerク`ラス
[RequestProcessorFactory.java](src/RequestProcessorFactory.java) : `page`文字列比較を行い、各操作を行うクラスのインスタンスを生成する。
[RequestProcessor.java](src/RequestProcessor.java) : 操作に関するメソッドを1つに纏めたインターフェイス。
[RequestConstants.java](src/RequestConstants.java) : 操作文字列を定数として管理しているクラス。

以下クラスは各操作を実行するクラス群 : 
[AllRequestProcessor.java](src/AllRequestProcessor.java)
[CompareRequestProcessor.java](src/CompareRequestProcessor.java)
[DeleteRequestProcessor.java](src/DeleteRequestProcessor.java)
[IssueRequestProcessor.java](src/IssueRequestProcessor.java)
[NextTargetRequestProcessor.java](src/NextTargetRequestProcessor.java)
[TemplateRequestProcessor.java](src/TemplateRequestProcessor.java)
[UpdateRequestProcessor.java](src/UpdateRequestProcessor.java)
[VersionsRequestProcessor.java](src/VersionsRequestProcessor.java)


## 実行の流れ
* `class Knock072.java` で `RequestProcessorFactory`クラスの`createRequestProcessor()`メソッドを実行。
	* `page`の値に関して、望ましい操作を行うクラスのインスタンスを生成。
	* 生成したインスタンスを`RequestProcessor`インターフェイスの型で取得。  
* `RequestProcessor`インターフェイスの`process()`メソッドを実行。
	* 上記で生成したクラスインスタンスの`process()`メソッドを実行。

