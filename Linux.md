## Linux

### 1.编写一个shell脚本(linux)，功能如下:在给定文件中搜索指定内容，并将搜索结果(含内容出现的行号)保存到新的文件中，同时结果输出到控制台

```sh
#!/bin/bash  
  
# 检查参数个数  
if [ $# -ne 3 ]; then  
  echo "Usage: $0 <source_file> <search_text> <output_file>"  
  exit 1  
fi  
  
# 获取参数  
SOURCE_FILE=$1  
SEARCH_TEXT=$2  
OUTPUT_FILE=$3  
  
# 检查源文件是否存在  
if [ ! -f $SOURCE_FILE ]; then  
  echo "Error: Source file not found!"  
  exit 1  
fi  
  
# 清空输出文件  
> $OUTPUT_FILE  
  
# 搜索并输出结果到文件和终端  
grep -n "$SEARCH_TEXT" $SOURCE_FILE | tee $OUTPUT_FILE
```



### 2.编写一个shell:显示当前硬盘使用情况，内存使用情况，CPU使用情况

```sh
#!/bin/sh

# 获取磁盘占用情况，并按行循环读取至output
df -H | grep -vE '^Filesystem|tmpfs|cdrom' | awk '{ print $5 " " $1 }' |  while read output;
do
  echo $output  # 输出结果
  
  # 通过 awk 获取占用百分比  cut -d 指定分隔符 获取 占比数字
  usep=$(echo $output | awk '{ print $1}' | cut -d'%' -f1  )
  # 获取文件路径
  partition=$(echo $output | awk '{ print $2 }' )
  # ; 用于分割命令，一行包括多个命令
  if [ $usep -ge 80 ]; then
    echo "Running out of space \"$partition ($usep%)\" on $(hostname) as on $(date)" ## 也可以发送报警邮件
  fi
done
```

