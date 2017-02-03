# 解答
* 以下のコマンドを実行する
```
$ java -Dhttp.proxyHost=proxy.example.com -Dhttp.proxyPort=80 -Dhttp.http.nonProxyHosts=*.noproxy.example.com Answer001
```
http.proxyHostオプションで、プロキシサーバのホスト名を指定
http.proxyPortオプションで、ポート番号を指定
http.nonProxyHostsオプションで、プロキシを省略して直接接続するホストを指定

# 参考
http://docs.oracle.com/javase/jp/8/docs/technotes/guides/net/proxies.html
