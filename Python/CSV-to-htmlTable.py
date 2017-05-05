import csv
import sys

def main():
	try:
		with open(str(sys.argv[1]), 'rb') as csvfile:
			spamreader = csv.reader(csvfile)
			first = True
			print '<table>'
			print '\t<tr>'
			for data in spamreader.next():
				print '\t\t<th>' + data + '</th>'
			print '\t</tr>'
			for row in spamreader:
				print '\t<tr>'
				for data in row:
					print '\t\t<td>' + data + '</td>'
				print '\t</tr>'
				first = False
			print '</table>'
			
			csvfile.close()
	except IndexError as err:
		print "Index Error: {0}".format(err)
	except IOError as err:
		print "IO Error: {0}".format(err)
		
main()