void merge(int vec[], int vecSize) {
  int mid;
  int i, j, k;
  int* tmp;

  tmp = (int*) malloc(vecSize * sizeof(int));

  mid = vecSize / 2;

  i = 0;
  j = mid;
  k = 0;
  while (i < mid && j < vecSize) {
    if (vec[i] <= vec[j]) {
      tmp[k] = vec[i++];
    }
    else {
      tmp[k] = vec[j++];
    }
    ++k;
  }

  if (i == mid) {
    while (j < vecSize) {
      tmp[k++] = vec[j++];
    }
  }
  else {
    while (i < mid) {
      tmp[k++] = vec[i++];

    }
  }

  for (i = 0; i < vecSize; ++i) {
    vec[i] = tmp[i];
      printf("%d ",vec[i]);
  }

  free(tmp);

}

void mergeSort(int vec[], int vecSize) {
  int mid;

  if (vecSize > 1) {
    mid = vecSize / 2;
    mergeSort(vec, mid);
    mergeSort(vec + mid, vecSize - mid);
    merge(vec, vecSize);
  }
}


main()
{

    int vet[]={5,7,9,4,3,6,8,1,2,0};
    mergeSort(vet,10);
    getchar();
    getchar();
}

