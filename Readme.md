# 概要

MySQLとSpring Bootを使用した簡単な検索ができるWebアプリケーションです。
このwebアプリケーションは「俳優」の情報を扱い、データの一覧表示、登録、削除を行います。

**開発環境**

下記の環境で開発および動作確認を行いました。

* Windows7 (64bit)
* Java 1.8.0_60
* Spring Boot 1.2.5
 * thymeleaf 2.1.4
 * logback 1.1.3
* MySQL CE 5.6
* Eclipse 4.4
* Maven 3.3.3

**事前準備**

サンプルデータを下記の通り準備します。

* データベース: `sample_db`
* ユーザー: `test_user`
* テーブル: `actor`, `prefecture`

データベース、ユーザー、テーブル、サンプルデータを作成するsqlは、resources/dataにあります。

## テーブル定義

使用するテーブルの定義は下記の通りです。

**actor**

俳優の情報を持つテーブルです。

|field               |data Type  |description              |
|:-------------------|:----------|:------------------------|
|id                  |整数       |ID                       |
|name                |文字列     |名前                     |
|height              |整数       |身長                     |
|blood               |文字列     |血液型                   |
|birthday            |日付       |誕生日                   |
|birthplace_id       |整数       |出身地ID                 |
|update_at           |日付       |データ更新日             |

**prefecture**

都道府県マスタです。

|field               |data Type  |description              |
|:-------------------|:----------|:------------------------|
|id                  |整数       |ID                       |
|name                |文字列      名前                     |

## 実行

MySQLサーバーを起動した状態で、下記のmvnコマンドでアプリケーションを実行します。

```bash
> mvn spring-boot:run
```

http://localhost:9000/actor
