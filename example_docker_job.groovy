freeStyleJob('freestyle job') {
	configure { project ->
        project / builders << 'org.foo.FooBuilder' {
            credentialsId('foo-password')
        }
    }
    scm {
	svn {
		location('https://svn2.prokarma.com/svn/dockertestapp/branches/junitmavenexample') {
                depth(SvnDepth.EMPTY)
            }
        }
	
    }
    steps {
        maven('clean install')
    }
}

