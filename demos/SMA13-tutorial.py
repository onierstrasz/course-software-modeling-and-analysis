# git clone git@github.com:DP-3T/dp3t-app-ios-ch.git

# pip3 install pydriller

# ipython

from pydriller import RepositoryMining

for commit in RepositoryMining('path/to/the/repo').traverse_commits():
    print('Hash {}, author {}'.format(commit.hash, commit.author.name))


# get all files currenty in the project
import os

files_and_committers = {}
path = 'dp3t-app-ios-ch'

# r=root, d=directories, f = files
for r, d, f in os.walk(path):
  for file in f:
    if '.swift' in file:
      files_and_committers[os.path.join(r, file)] = []

for f in files_and_committers:
  print(f)


for commit in RepositoryMining(path).traverse_commits():
  for modification in commit.modifications:
    if modification.new_path and '.swift' in modification.new_path:
      print('Author {} modified {} in commit {}'.format(commit.author.name, os.path.join(path,modification.new_path), commit.hash))


for commit in RepositoryMining(path).traverse_commits():
  for modification in commit.modifications:
    if modification.new_path and '.swift' in modification.new_path:
      filename = os.path.join(path,modification.new_path)
        if filename in files_and_committers:
    	  files_and_committers[filename].append(commit.author.name)

files_and_committers['dp3t-app-ios-ch/DP3TApp/Screens/Reports/NSReportsDetailNoReportsTitleView.swift']
files_and_committers['dp3t-app-ios-ch/DP3TApp/Screens/Homescreen/InformBroadcast/Symptoms/NSCheckboxControl.swift']

from collections import Counter
c = Counter(files_and_committers['dp3t-app-ios-ch/DP3TApp/Screens/Homescreen/InformBroadcast/Symptoms/NSCheckboxControl.swift'])

ltotal = len(set(files_and_committers['dp3t-app-ios-ch/DP3TApp/Screens/Homescreen/InformBroadcast/Symptoms/NSCheckboxControl.swift']))
lminor = len([c for name,commits in c.items() if commits < (sum(c.values())*0.2)])
lmajor = ltotal - lminor
lownership = max(c.values())/sum(c.values())

results = []

for filename, committers in files_and_committers.items():
  values = {}
  c = Counter(committers)
  values['total'] = len(c.keys())
  values['minor'] = len([c for name,commits in c.items() if commits < (sum(c.values())*0.2)])
  values['major'] = values['total'] - values['minor']
  values['ownership'] = max(c.values())/sum(c.values())
  values['name'] = filename
  results.append(values)

import csv

csv_columns = ['name','total','minor','major','ownership']

csv_file = 'results.csv'

try:
  with open(csv_file, 'w') as csvfile:
    writer = csv.DictWriter(csvfile, fieldnames=csv_columns)
    writer.writeheader()
    for data in results:
      writer.writerow(data)
except IOError:
  print("I/O error")

