作业反馈
======================

## Well

1. 代码格式有很大进步，更规范了

## Less Well

1. 学会使用gitignore，将没必要放到代码仓库的文件ignore掉，比如
    -- idea的工程文件*.iml, *.ipr, *. iws
    -- 构件输出文件夹build(gradle的)，out(idea的)
    -- gradle相关文件夹
2. guava要使用最新版本的，13已经很老了
3. Java程序要使用包进行管理，不要直接将class放到source目录下（这里是/src/main/java和/src/test/java），反映在代码上面就是java类中没用使用package。