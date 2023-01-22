node {
    checkout scm
    properties([
        parameters([
            string(
                name: 'VERSION',
                    description: '''\
                        作成したいインデックスのバージョンを指定(例. v1)
                        ここで指定したバージョンが「インデックス名-バージョン名」として付与される
                    '''.stripIndent()
            )
        ])
    ])
    stage("Create Index"){
        sh "curl -X PUT -d @./books.json http://opensearch:9200/books-${VERSION}"
    }
}
