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
    stage("Switch alias") {
        git branch: 'opensearch-playground', url: 'https://github.com/daisuzz/jenkins-playground.git'
        sh "curl -XPOST -H 'Content-Type:application/json' http://opensearch:9200/_alias -d {'actions': [{'remove': {'index': 'books-${OLD_VERSION}','alias': 'books'}},{'add': {'index': 'books-${NEW_VERSION}','alias':'books'}}]}"
    }
    stage("Delete old index") {
        sh "curl -XDELETE http://opensearch:9200/books-${OLD_VERSION}"
    }
}
