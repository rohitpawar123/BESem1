#import dataset
data<-read.csv("iris.csv")

#Number of features
print(ncol(data))


# column names and their types
for (nums in cols)
  print(paste(nums,typeof(nums)))

#print min max mean sd variance percentile and  range
print(max(data$Sepal.Length))
print(min(data$Sepal.Length))
print(mean(data$Sepal.Length))
print(sd(data$Sepal.Length))
print(range(data$Sepal.Length))
print(var(data$Sepal.Length))
print(quantile(data$Sepal.Length))

#print histogram of sepal length and boxplot for all features combined
hist(data$Sepal.Length)
boxplot(data[,-1])
#print(subset(data,Sepal.Length==max(Sepal.Length)))

#png(file="boxplot.png")
#boxplot(Sepal.Length ~ Species, data= data, xlab= "Species", ylab="Sepal Length", main="Length Data")
#hist(data$Sepal.Length, xlab="Length")
#dev.off()

#summary(data)

