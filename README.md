# microsoft-graph

## 準備

### Office365試用版アカウント登録
https://products.office.com/ja-jp/try

### Microsoft Azure のサブスクリプション 登録

https://manage.windowsazure.com/

Azure Active Directoryにアプリケーションを登録し、以下を取得します。

- クライアントID
- リダイレクトURL

【参考】http://blog.rykoma.net/2016/04/03/591/

## 実際のリクエスト

1. Azure Active Directoryライブラリのメソッドを呼び出して、ユーザーを認証し、アクセストークンを取得します。

2. Microsoft Graph APIエンドポイントでREST操作としてメールメッセージ要求を作成します。
