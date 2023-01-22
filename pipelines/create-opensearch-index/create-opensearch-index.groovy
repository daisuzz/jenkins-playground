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
        git branch: 'opensearch-playground', url: 'https://github.com/daisuzz/jenkins-playground.git'
        sh "curl -X PUT -d @./pipelines/create-opensearch-index/books.json http://opensearch:9200/books-${VERSION}"
    }
}
