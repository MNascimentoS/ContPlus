#include "mainwindow.h"
#include "lancamentowindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    this->setStyleSheet("background-color: white;");
    this->setFixedSize(this->width(), this->height());
    QPixmap pix = QPixmap("logo.png");
    pix = pix.scaled(200, 200, Qt::KeepAspectRatio, Qt::SmoothTransformation);
    ui->logo->setPixmap(pix);
    QHeaderView* header = ui->tableWidget->horizontalHeader();
    header->setSectionResizeMode(QHeaderView::Stretch);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_btn_lancamento_clicked()
{
    LancamentoWindow *lw = new LancamentoWindow();
    lw->show();
}
