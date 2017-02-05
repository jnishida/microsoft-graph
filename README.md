# microsoft-graph

## 準備

Azure Active Directoryにアプリケーションを登録し、以下を取得する。

- クライアントID
- リダイレクトURL

## 実際のリクエスト

1. Azure Active Directoryライブラリのメソッドを呼び出して、ユーザーを認証し、アクセストークンを取得します。

2. Microsoft Graph APIエンドポイントでREST操作としてメールメッセージ要求を作成します。
